import PlantCard from "./PlantCard";

function PlantCollection({plants, deletePlant, updatePlantNickname, userId}) {
    return (
        <section className="plant-collection">
            {plants.length === 0 ? <p>No plants yet! Add your first plant!</p> : 
                plants.map((plant) => (
                    <PlantCard key={plant.plantId} plant={plant} deletePlant={deletePlant} updatePlantNickname={updatePlantNickname} userId={userId} />
                ))
            }
        </section>
    )
}

export default PlantCollection;