import PlantCollection from "./PlantCollection";
import { useState } from "react";
import AddPlantForm from "./AddPlantForm";

function CollectionPage({plants, addPlant, deletePlant, updatePlantNickname, userId}) {
    //prevents the form from being viewed until user adds a new plant
    const [showForm, setShowForm] = useState(false)
    
    const handleForm = () => {
        setShowForm(!showForm)
    }
    return (
        <div>
            <h2>Plant Collection</h2>
            <button onClick={handleForm}>
                {showForm ? 'Cancel' : 'Add a Plant'}
            </button>
            {showForm && <AddPlantForm plants={plants} addPlant={addPlant} close={handleForm} />}
            <PlantCollection plants={plants} deletePlant={deletePlant} updatePlantNickname={updatePlantNickname} userId={userId} />
        </div>
    )
}

export default CollectionPage;