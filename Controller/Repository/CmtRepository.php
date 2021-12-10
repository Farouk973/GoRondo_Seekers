<?php

namespace App\Repository;

use App\Entity\Cmt;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method Cmt|null find($id, $lockMode = null, $lockVersion = null)
 * @method Cmt|null findOneBy(array $criteria, array $orderBy = null)
 * @method Cmt[]    findAll()
 * @method Cmt[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class CmtRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, Cmt::class);
    }

    // /**
    //  * @return Cmt[] Returns an array of Cmt objects
    //  */
    /*
    public function findByExampleField($value)
    {
        return $this->createQueryBuilder('c')
            ->andWhere('c.exampleField = :val')
            ->setParameter('val', $value)
            ->orderBy('c.id', 'ASC')
            ->setMaxResults(10)
            ->getQuery()
            ->getResult()
        ;
    }
    */

    /*
    public function findOneBySomeField($value): ?Cmt
    {
        return $this->createQueryBuilder('c')
            ->andWhere('c.exampleField = :val')
            ->setParameter('val', $value)
            ->getQuery()
            ->getOneOrNullResult()
        ;
    }
    */
}
