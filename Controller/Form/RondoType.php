<?php

namespace App\Form;

use App\Entity\Rondo;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;

class RondoType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('typeActivite')
            ->add('lieuxEvent')
            ->add('prix')
            ->add('idTransport')
            ->add('duree')
            ->add('groupe')
            ->add('dateEvent')
        ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => Rondo::class,
        ]);
    }
}
