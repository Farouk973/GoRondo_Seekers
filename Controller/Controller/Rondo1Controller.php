<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class Rondo1Controller extends AbstractController
{
    /**
     * @Route("/rondo1", name="rondo1")
     */
    public function index(): Response
    {
        return $this->render('rondo1/index.html.twig', [
            'controller_name' => 'Rondo1Controller',
        ]);
    }
}
