//passing psecies as a prop instead of plant to get species data independently
function PlantCareInfo({species}) {
    return (
        <table>
            <tbody>
                <tr>
                    <th>Watering:</th>
                    <td>Every {species.wateringFrequency} days</td>
                </tr>
                <tr>
                    <th>Lighting:</th>
                    <td>{species.lightRequirement}</td>
                </tr>
                <tr>
                    <th>Care Notes:</th>
                    <td>{species.careInfo}</td>
                </tr>
            </tbody>
        </table>
    )
}

export default PlantCareInfo;