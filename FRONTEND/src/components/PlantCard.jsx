import { useState } from "react";
import ConfirmModal from "./ConfirmModal";
import PlantCareInfo from "./PlantCareInfo";

function PlantCard({plant, deletePlant, updatePlantNickname, userId}) {
    const [showModal, setShowModal] = useState(false);
    const [showCareInfo, setShowCareInfo] = useState(false);
    // New state to hold species information
    const [speciesInfo, setSpeciesInfo] = useState(null);
    // New state to manage editing mode and new nickname
    const [editing, setEditing] = useState(false);
    const [newNickname, setNewNickname] = useState(plant.nickname);

    const handleDelete = () => {
        setShowModal(true)
    }

    const handleConfirm = () => {
        deletePlant(plant.plantId)
        setShowModal(false)
    }

    const handleCancel = () => {
        setShowModal(false)
    }

    const handleToggle = async () => {
        if (!showCareInfo && !speciesInfo) {
            try {
                const response = await fetch(`http://localhost:8080/speciesInfo/${plant.speciesName}`);
                const data = await response.json();
                setSpeciesInfo(data);
            } catch (error) {
                console.error('Error fetching species info:', error);
            }
        }
        setShowCareInfo(!showCareInfo);
    }

    const handleEditing = async () => {
        try {
            const response = await fetch(`http://localhost:8080/users/${userId}/plants/${plant.plantId}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ nickname: newNickname })
            });
            if (response.ok) {
                updatePlantNickname(plant.plantId, newNickname);
                setEditing(false);
            } else {
                console.error('Failed to update plant nickname');
            }
        } catch (error) {
            console.error('Error updating plant nickname:', error);
        }
    }

    return (
        <article className="plant-card">
            <img src={plant.plantImageURL} alt={`An image of ${plant.speciesName}`} />
            <div className="plant-card-body">
                {editing ? (
                    <div className="edit-nickname">
                        <input type="text" value={newNickname} onChange={(e) => setNewNickname(e.target.value)} className="nickname-input" />
                        <button onClick={handleEditing} className="save-btn">Save</button>
                        <button onClick={() => setEditing(false)} className="cancel-btn">Cancel</button>
                    </div>) : (
                    <div className="nickname-display">
                        <h3>{plant.nickname}</h3>
                        <button onClick={() => setEditing(true)} className="edit-btn">Edit</button>
                    </div>
                    )}

                <p>{plant.speciesName}</p>
                <span className={plant.species.toxic ? "badge-toxic" : "badge-safe"}>
                    {plant.species.toxic ? "Toxic to Pets" : "Safe for Pets"}
                </span>
                <div className="plant-card-buttons">
                    <button className="btn-danger" onClick={handleDelete}> Remove Plant</button>
                    {showModal && (
                        <ConfirmModal message={`Are you sure you want to remove ${plant.nickname} from your collection?`} confirm={handleConfirm} cancel={handleCancel} />
                    )}
                    <button className="btn-toggle" onClick={handleToggle}>
                        {showCareInfo ? '-' : '+'}
                    </button>
                    {showCareInfo && (<PlantCareInfo species={speciesInfo} />)}
                </div>
            </div>
        </article>
    )
}

export default PlantCard;