<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Rondo
 *
 * @ORM\Table(name="rondo")
 * @ORM\Entity(repositoryClass="App\Repository\Rondorepository")
 */
class Rondo
{
    /**
     * @var int
     *
     * @ORM\Column(name="id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var string
     *
     * @ORM\Column(name="type_activite", type="string", length=255, nullable=false)
     */
    private $typeActivite;

    /**
     * @var string
     *
     * @ORM\Column(name="lieux_event", type="string", length=255, nullable=false)
     */
    private $lieuxEvent;

    /**
     * @var int
     *
     * @ORM\Column(name="prix", type="integer", nullable=false)
     */
    private $prix;

    /**
     * @var int
     *
     * @ORM\Column(name="id_transport", type="integer", nullable=false)
     */
    private $idTransport;

    /**
     * @var int
     *
     * @ORM\Column(name="duree", type="integer", nullable=false)
     */
    private $duree;

    /**
     * @var string
     *
     * @ORM\Column(name="groupe", type="string", length=255, nullable=false)
     */
    private $groupe;

    /**
     * @var int
     *
     * @ORM\Column(name="date_event", type="integer", nullable=false)
     */
    private $dateEvent;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getTypeActivite(): ?string
    {
        return $this->typeActivite;
    }

    public function setTypeActivite(string $typeActivite): self
    {
        $this->typeActivite = $typeActivite;

        return $this;
    }

    public function getLieuxEvent(): ?string
    {
        return $this->lieuxEvent;
    }

    public function setLieuxEvent(string $lieuxEvent): self
    {
        $this->lieuxEvent = $lieuxEvent;

        return $this;
    }

    public function getPrix(): ?int
    {
        return $this->prix;
    }

    public function setPrix(int $prix): self
    {
        $this->prix = $prix;

        return $this;
    }

    public function getIdTransport(): ?int
    {
        return $this->idTransport;
    }

    public function setIdTransport(int $idTransport): self
    {
        $this->idTransport = $idTransport;

        return $this;
    }

    public function getDuree(): ?int
    {
        return $this->duree;
    }

    public function setDuree(int $duree): self
    {
        $this->duree = $duree;

        return $this;
    }

    public function getGroupe(): ?string
    {
        return $this->groupe;
    }

    public function setGroupe(string $groupe): self
    {
        $this->groupe = $groupe;

        return $this;
    }

    public function getDateEvent(): ?int
    {
        return $this->dateEvent;
    }

    public function setDateEvent(int $dateEvent): self
    {
        $this->dateEvent = $dateEvent;

        return $this;
    }


}
