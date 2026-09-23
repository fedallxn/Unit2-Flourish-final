import pothos from './assets/plantImages/pothos.jpg'
import monstera from './assets/plantImages/monstera.jpg'
import spiderPlant from './assets/plantImages/spiderPlant.jpg'
import snakePlant from './assets/plantImages/snakePlant.jpg'
import fiddleLeafFig from './assets/plantImages/fiddleLeafFig.jpg'
import peaceLily from './assets/plantImages/peaceLily.jpg'

const mockPlantData = [
    {
        id: 1,
        image: pothos,
        imageAlt: 'A photo of a small hanging pothos plant with green heart-shaped leaves',
        health: 100,
        lastWartered: '03-10-2026',
        name: 'Pothos',
        species: 'Epipremnum aureum',
        sunlightNeeds: 'Low to Medium',
        isToxic: true,
        wateringFrequency: 7
    },
    {
        id: 2,
        image: monstera,
        imageAlt: 'A photot of a large monstera plant with large split leaves',
        health: 100,
        lastWartered: '03-08-2026',
        name: 'Monstera',
        species: 'Monstera deliciosa',
        sunlightNeeds: 'Medium to Bright Indirect',
        isToxic: true,
        wateringFrequency: 10
    },
    {
        id: 3,
        image: spiderPlant,
        imageAlt: 'A photo of a large spider plant with arching green and white striated leaves in a glossy, blue and white patterned pot',
        health: 100,
        lastWartered: '03-14-2026',
        name: 'Spider Plant',
        species: 'Chlorophytum comosum',
        sunlightNeeds: 'Bright Indirect',
        isToxic: false,
        wateringFrequency: 7
    },
    {
        id: 4,
        image: snakePlant,
        imageAlt: 'A photo of a snake plant with tall swoard shaped leaves that are striped with with different colors of green',
        health: 100,
        lastWartered: '03-05-2026',
        name: 'Snake Plant',
        species: 'Sansevieria trifasciata',
        sunlightNeeds: 'Low to Bright Indirect',
        isToxic: true,
        wateringFrequency: 14
    },
    {
        id: 5,
        image: fiddleLeafFig,
        imageAlt: 'A photo of a fiddle leaf fig plant with large violin shaped glassy leaves',
        health: 100,
        lastWartered: '03-15-2026',
        name: 'Fiddle leaf Fig',
        species: 'Ficus lyrata',
        sunlightNeeds: 'Bright Indirect',
        isToxic: true,
        wateringFrequency: 10
    },
    {
        id: 6,
        image: peaceLily,
        imageAlt: 'A photo of a peace lily with dark green leaves and white blossoms with a spikey stamen',
        health: 100,
        lastWartered: '03-12-2026',
        name: 'Peace Lily',
        species: 'Spathiphyllum wallisii',
        sunlightNeeds: 'Low to Medium Indirect',
        isToxic: true,
        wateringFrequency: 7
    }
]

export default mockPlantData;