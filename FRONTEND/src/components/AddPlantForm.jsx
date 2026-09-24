import { useState } from "react";

function AddPlantForm({addPlant, close}) {
    const [formData, setFormData] = useState({
        nickname: '',
        speciesName: '',
    })

    //this handleChange function is diff. from the contact form because it checks the type of input first since a checkbox is boolean
    const handleChange = (e) => {
        const {name, value} = e.target;
        setFormData((prevData) => ({
            ...prevData,
            [name]: value
        }))
    }

    const handleSubmit = (e) => {
        e.preventDefault()

        const newPlant = {
            nickname: formData.nickname,
            speciesName: formData.speciesName,
        }

        addPlant(newPlant)
        close()
    }

    return (
        <section>
            <h3>Add a Plant</h3>
            <form onSubmit={handleSubmit}>
                <label>Plant Nickname:
                    <input type="text" name="nickname" value={formData.nickname} onChange={handleChange} placeholder="e.g. Regina" required />
                </label><br />
                <label>Plant Species:
                    <input type="text" name="speciesName" value={formData.speciesName} onChange={handleChange} placeholder="e.g. Christmas Cactus" required />
                </label><br />
                <button type="submit">Add Plant</button>
            </form>
        </section>
    )
}

export default AddPlantForm;