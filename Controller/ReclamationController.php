<?php

namespace App\Controller;

use App\Entity\Reclamation;
use App\Form\ReclamationType;
use App\Repository\Reclamrepository;
use Doctrine\DBAL\Types\TextType;
use phpDocumentor\Reflection\Type;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Mailer\Mailer;
use Symfony\Component\Mailer\Bridge\Google\Transport\GmailSmtpTransport;
use Symfony\Component\Mailer\MailerInterface;
use Symfony\Component\Mime\Email;
use Symfony\Component\Routing\Annotation\Route;
use Knp\Component\Pager\PaginatorInterface;



/**
 * @Route("/reclamation")
 */
class ReclamationController extends AbstractController
{
    /**
     * @Route("/", name="reclamation_index", methods={"GET"})
     */
    public function index(Reclamrepository $reclamrepository,Request $request, PaginatorInterface $paginator): Response
    {
        $donnees = $this->getDoctrine()->getRepository(Reclamation::class)->findBy([],['nomReclam' => 'desc']);

        $reclamation = $paginator->paginate(
            $donnees, // Requête contenant les données à paginer (ici nos articles)
            $request->query->getInt('page', 1), // Numéro de la page en cours, passé dans l'URL, 1 si aucune page
            6 // Nombre de résultats par page
        );

        return $this->render('reclamation/index.html.twig', [
            'reclamations' =>$reclamation,

        ]);
    }

    /**
     * @Route("/new", name="reclamation_new", methods={"GET","POST"})
     */
    public function new(Request $request,MailerInterface $mailer): Response
    {
        $reclamation = new Reclamation();
        $form = $this->createForm(ReclamationType::class, $reclamation);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($reclamation);
            $entityManager->flush();
            $email = (new Email())
                ->from('goo.resultat@gmail.com')
                ->to($form["adresseReclam"]->getData())
                //->cc('cc@example.com')
                //->bcc('bcc@example.com')
                //->replyTo('fabien@example.com')
                //->priority(Email::PRIORITY_HIGH)
                ->subject('GO RANDO')
                ->text('Sending emails is fun again!')
                ->html('<p> Votre reclamation est bien reçu .nous vous repondrons le plus tot possible</p>');

            $mailer->send($email);
            $this->addFlash('message', 'Votre message a été transmis, nous vous répondrons dans les meilleurs délais.');




            return $this->redirectToRoute('reclamation_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('reclamation/new.html.twig', [
            'reclamation' => $reclamation,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idReclam}", name="reclamation_show", methods={"GET"})
     */
    public function show(Reclamation $reclamation): Response
    {
        return $this->render('reclamation/show.html.twig', [
            'reclamation' => $reclamation,
        ]);
    }

    /**
     * @Route("/{idReclam}/edit", name="reclamation_edit", methods={"GET","POST"})
     */
    public function edit(Request $request, Reclamation $reclamation): Response
    {
        $form = $this->createForm(ReclamationType::class, $reclamation);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('reclamation_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('reclamation/edit.html.twig', [
            'reclamation' => $reclamation,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idReclam}", name="reclamation_delete", methods={"POST"})
     */
    public function delete(Request $request, Reclamation $reclamation): Response
    {
        if ($this->isCsrfTokenValid('delete' . $reclamation->getIdReclam(), $request->request->get('_token'))) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->remove($reclamation);
            $entityManager->flush();
        }

        return $this->redirectToRoute('reclamation_index', [], Response::HTTP_SEE_OTHER);
    }

}