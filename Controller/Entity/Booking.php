<?php

namespace App\Entity;

use App\Repository\BookingRepository;
use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Entity(repositoryClass=BookingRepository::class)
 */
class Booking
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @ORM\Column(type="date")
     */
    private $beginat;

    /**
     * @ORM\Column(type="date", nullable=true)
     */
    private $endAt;

    /**
     * @ORM\Column(type="integer")
     */
    private $id_booking;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getBeginat(): ?\DateTimeInterface
    {
        return $this->beginat;
    }

    public function setBeginat(\DateTimeInterface $beginat): self
    {
        $this->beginat = $beginat;

        return $this;
    }

    public function getEndAt(): ?\DateTimeInterface
    {
        return $this->endAt;
    }

    public function setEndAt(?\DateTimeInterface $endAt): self
    {
        $this->endAt = $endAt;

        return $this;
    }

    public function getIdBooking(): ?int
    {
        return $this->id_booking;
    }

    public function setIdBooking(int $id_booking): self
    {
        $this->id_booking = $id_booking;

        return $this;
    }
}
