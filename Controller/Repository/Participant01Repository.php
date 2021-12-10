<?php

namespace App\Repository;

use App\Entity\Participant01;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method Participant01|null find($id, $lockMode = null, $lockVersion = null)
 * @method Participant01|null findOneBy(array $criteria, array $orderBy = null)
 * @method Participant01[]    findAll()
 * @method Participant01[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class Participant01Repository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Participant01::class);
    }

    // /**
    //  * @return Participant01[] Returns an array of Participant01 objects
    //  */
    /*
    public function findByExampleField($value)
    {
        return $this->createQueryBuilder('p')
            ->andWhere('p.exampleField = :val')
            ->setParameter('val', $value)
            ->orderBy('p.id', 'ASC')
            ->setMaxResults(10)
            ->getQuery()
            ->getResult()
        ;
    }
    */

    /*
    public function findOneBySomeField($value): ?Participant01
    {
        return $this->createQueryBuilder('p')
            ->andWhere('p.exampleField = :val')
            ->setParameter('val', $value)
            ->getQuery()
            ->getOneOrNullResult()
        ;
    }
    */
}
