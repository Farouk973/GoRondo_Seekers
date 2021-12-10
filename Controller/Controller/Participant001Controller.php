<?php

namespace App\Controller;

use App\Entity\Participant01;
use App\Form\Participant01Type;
use App\Repository\Participant01Repository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/participant001")
 */
class Participant001Controller extends AbstractController
{
    /**
     * @Route("/", name="participant001_index", methods={"GET"})
     */
    public function index(Participant01Repository $participant01Repository): Response
    {
        return $this->render('participant001/index.html.twig', [
            'participant01s' => $participant01Repository->findAll(),
        ]);
    }

    /**
     * @Route("/new", name="participant001_new", methods={"GET", "POST"})
     */
    public function new(Request $request, EntityManagerInterface $entityManager): Response
    {
        $participant01 = new Participant01();
        $form = $this->createForm(Participant01Type::class, $participant01);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->persist($participant01);
            $entityManager->flush();

            return $this->redirectToRoute('participant001_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('participant001/new.html.twig', [
            'participant01' => $participant01,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="participant001_show", methods={"GET"})
     */
    public function show(Participant01 $participant01): Response
    {
        return $this->render('participant001/show.html.twig', [
            'participant01' => $participant01,
        ]);
    }

    /**
     * @Route("/{id}/edit", name="participant001_edit", methods={"GET", "POST"})
     */
    public function edit(Request $request, Participant01 $participant01, EntityManagerInterface $entityManager): Response
    {
        $form = $this->createForm(Participant01Type::class, $participant01);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->flush();

            return $this->redirectToRoute('participant001_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('participant001/edit.html.twig', [
            'participant01' => $participant01,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="participant001_delete", methods={"POST"})
     */
    public function delete(Request $request, Participant01 $participant01, EntityManagerInterface $entityManager): Response
    {
        if ($this->isCsrfTokenValid('delete'.$participant01->getId(), $request->request->get('_token'))) {
            $entityManager->remove($participant01);
            $entityManager->flush();
        }

        return $this->redirectToRoute('participant001_index', [], Response::HTTP_SEE_OTHER);
    }
}
