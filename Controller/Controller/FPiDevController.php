<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class FPiDevController extends AbstractController
{
    /**
     * @Route("/f/pi/dev", name="f_pi_dev")
     */
    public function index(): Response
    {
        return $this->render('f_pi_dev/index.html.twig', [
            'controller_name' => 'FPiDevController',
        ]);
    }
}
