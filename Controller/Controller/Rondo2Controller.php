<?php

namespace App\Controller;

use App\Entity\Rondo;
use App\Form\Rondo1Type;
use App\Repository\Rondorepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/rondo2")
 */
class Rondo2Controller extends AbstractController
{
    /**
     * @Route("/", name="rondo2_index", methods={"GET"})
     */
    public function index(Rondorepository $rondorepository): Response
    {
        return $this->render('rondo2/index.html.twig', [
            'rondos' => $rondorepository->findAll(),
        ]);
    }

    /**
     * @Route("/new", name="rondo2_new", methods={"GET","POST"})
     */
    public function new(Request $request): Response
    {
        $rondo = new Rondo();
        $form = $this->createForm(Rondo1Type::class, $rondo);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($rondo);
            $entityManager->flush();

            return $this->redirectToRoute('rondo2_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('rondo2/new.html.twig', [
            'rondo' => $rondo,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="rondo2_show", methods={"GET"})
     */
    public function show(Rondo $rondo): Response
    {
        return $this->render('rondo2/show.html.twig', [
            'rondo' => $rondo,
        ]);
    }

    /**
     * @Route("/{id}/edit", name="rondo2_edit", methods={"GET","POST"})
     */
    public function edit(Request $request, Rondo $rondo): Response
    {
        $form = $this->createForm(Rondo1Type::class, $rondo);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('rondo2_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('rondo2/edit.html.twig', [
            'rondo' => $rondo,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="rondo2_delete", methods={"POST"})
     */
    public function delete(Request $request, Rondo $rondo): Response
    {
        if ($this->isCsrfTokenValid('delete'.$rondo->getId(), $request->request->get('_token'))) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->remove($rondo);
            $entityManager->flush();
        }

        return $this->redirectToRoute('rondo2_index', [], Response::HTTP_SEE_OTHER);
    }
}
