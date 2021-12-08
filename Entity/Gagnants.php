<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Gagnants
 *
 * @ORM\Table(name="gagnants")
 * @ORM\Entity(repositoryClass="App\Repository\Gagnantrepository")
 */
class Gagnants
{
    /**
     * @var int
     *
     * @ORM\Column(name="Id_gagnant", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idGagnant;

    /**
     * @var string
     *
     * @ORM\Column(name="Nom_gagnant", type="string", length=20, nullable=false)
     */
    private $nomGagnant;

    /**
     * @var string
     *
     * @ORM\Column(name="Prenom_gagnant", type="string", length=20, nullable=false)
     */
    private $prenomGagnant;

    /**
     * @var string
     *
     * @ORM\Column(name="Adresse_gagnant", type="string", length=20, nullable=false)
     */
    private $adresseGagnant;
    public function getIdGagnant(): ?int
    {
        return $this->idGagnant;
    }

    public function getNomGagnant(): ?string
    {
        return $this->nomGagnant;
    }

    public function setNomGagnant(string $nomGagnant): self
    {
        $this->nomGagnant = $nomGagnant;

        return $this;
    }

    public function getPrenomGagnant(): ?string
    {
        return $this->prenomGagnant;
    }

    public function setPrenomGagnant(string $prenomGagnant): self
    {
        $this->prenomGagnant = $prenomGagnant;

        return $this;
    }

    public function getAdresseGagnant(): ?string
    {
        return $this->adresseGagnant;
    }

    public function setAdresseGagnant(string $adresseGagnant): self
    {
        $this->adresseGagnant = $adresseGagnant;

        return $this;
    }


}
