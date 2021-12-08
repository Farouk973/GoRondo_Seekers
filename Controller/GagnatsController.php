<?php

namespace App\Controller;

use App\Entity\Gagnants;
use App\Form\GagnantsType;
use App\Repository\Gagnantrepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Mailer\MailerInterface;
use Symfony\Component\Mime\Email;
use Symfony\Component\Routing\Annotation\Route;

use Knp\Component\Pager\PaginatorInterface;
/**
 * @Route("/gagnats")
 */
class GagnatsController extends AbstractController
{
    /**
     * @Route("/", name="gagnats_index", methods={"GET"})
     */
    public function index(Gagnantrepository $gagnantrepository,Request $request, PaginatorInterface $paginator): Response
    {

        $donnees = $this->getDoctrine()->getRepository(Gagnants::class)->findBy([],['nomGagnant' => 'desc']);

        $gagnant = $paginator->paginate(
            $donnees, // Requête contenant les données à paginer (ici nos articles)
            $request->query->getInt('page', 1), // Numéro de la page en cours, passé dans l'URL, 1 si aucune page
            6 // Nombre de résultats par page
        );


        return $this->render('gagnats/index.html.twig', [
            'gagnants' => $gagnant,
        ]);
    }

    /**
     * @Route("/new", name="gagnats_new", methods={"GET","POST"})
     */
    public function new(Request $request,MailerInterface $mailer): Response
    {
        $gagnant = new Gagnants();
        $form = $this->createForm(GagnantsType::class, $gagnant);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($gagnant);
            $entityManager->flush();
            $email = (new Email())
                ->from('goo.resultat@gmail.com')
                ->to($form["adresseGagnant"]->getData())
                //->cc('cc@example.com')
                //->bcc('bcc@example.com')
                //->replyTo('fabien@example.com')
                //->priority(Email::PRIORITY_HIGH)
                ->subject('GO RANDO')
                ->text('Sending emails is fun again!')
                ->html('<p> CONGRATS ! VOUS AVEZ GAGNER UNE RANDONNE GRATUITE</p>');

            $mailer->send($email);
            $this->addFlash('message', 'Votre message a été transmis, nous vous répondrons dans les meilleurs délais.');



           return $this->redirectToRoute('gagnats_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('gagnats/new.html.twig', [
            'gagnant' => $gagnant,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idGagnant}", name="gagnats_show", methods={"GET"})
     */
    public function show(Gagnants $gagnant): Response
    {
        return $this->render('gagnats/show.html.twig', [
            'gagnant' => $gagnant,
        ]);
    }

    /**
     * @Route("/{idGagnant}/edit", name="gagnats_edit", methods={"GET","POST"})
     */
    public function edit(Request $request, Gagnants $gagnant): Response
    {
        $form = $this->createForm(GagnantsType::class, $gagnant);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('gagnats_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('gagnats/edit.html.twig', [
            'gagnant' => $gagnant,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idGagnant}", name="gagnats_delete", methods={"POST"})
     */
    public function delete(Request $request, Gagnants $gagnant): Response
    {
        if ($this->isCsrfTokenValid('delete' . $gagnant->getIdGagnant(), $request->request->get('_token'))) {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->remove($gagnant);
            $entityManager->flush();
        }

        return $this->redirectToRoute('gagnats_index', [], Response::HTTP_SEE_OTHER);

    }

    /**
     * @Route("/trie", name="gagnats_indexyyy")
     */
    public function AfficheGaganatsByName(Gagnantrepository $repository)
    {
        $gagnant = $this->getDoctrine()->getRepository(Gagnants::class)->listgagByName();

        return $this->render('gagnats/index.html.twig', [], Response::HTTP_SEE_OTHER);;
    }

}
