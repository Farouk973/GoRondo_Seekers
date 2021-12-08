<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Reclamation
 *
 * @ORM\Table(name="reclamation")
 * @ORM\Entity(repositoryClass="App\Repository\Reclamrepository")
 */
class Reclamation
{
    /**
     * @var int
     *
     * @ORM\Column(name="Id_reclam", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idReclam;

    /**
     * @var string
     *
     * @ORM\Column(name="Nom_reclam", type="string", length=20, nullable=false)
     */
    private $nomReclam;

    /**
     * @var string
     *
     * @ORM\Column(name="Prenom_reclam", type="string", length=20, nullable=false)
     */
    private $prenomReclam;

    /**
     * @var string
     *
     * @ORM\Column(name="Adresse_reclam", type="string", length=100, nullable=false)
     */
    private $adresseReclam;

    /**
     * @var string
     *
     * @ORM\Column(name="RECLAM", type="string", length=50, nullable=false)
     */
    private $reclam;

    public function getIdReclam(): ?int
    {
        return $this->idReclam;
    }

    public function getNomReclam(): ?string
    {
        return $this->nomReclam;
    }

    public function setNomReclam(string $nomReclam): self
    {
        $this->nomReclam = $nomReclam;

        return $this;
    }

    public function getPrenomReclam(): ?string
    {
        return $this->prenomReclam;
    }

    public function setPrenomReclam(string $prenomReclam): self
    {
        $this->prenomReclam = $prenomReclam;

        return $this;
    }

    public function getAdresseReclam(): ?string
    {
        return $this->adresseReclam;
    }

    public function setAdresseReclam(string $adresseReclam): self
    {
        $this->adresseReclam = $adresseReclam;

        return $this;
    }

    public function getReclam(): ?string
    {
        return $this->reclam;
    }

    public function setReclam(string $reclam): self
    {
        $this->reclam = $reclam;

        return $this;
    }
    protected $captchaCode;

    public function getCaptchaCode()
    {
        return $this->captchaCode;
    }

    public function setCaptchaCode($captchaCode)
    {
        $this->captchaCode = $captchaCode;
    }


}


