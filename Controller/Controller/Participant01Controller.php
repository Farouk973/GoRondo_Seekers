<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class Participant01Controller extends AbstractController
{
    /**
     * @Route("/participant01", name="participant01")
     */
    public function index(): Response
    {
        return $this->render('participant01/index.html.twig', [
            'controller_name' => 'Participant01Controller',
        ]);
    }
}
