import './App.css'
import Header from './components/Header'
import Footer from './components/Footer'
import HomePage from './components/HomePage'
import CollectionPage from './components/CollectionPage'
import AboutPage from './components/AboutPage'
import ContactPage from './components/ContactPage'
import { useState, useEffect } from 'react'
import { Route, Routes } from 'react-router-dom'

function App() {
  const [userId, setUserId] = useState(2);
  const [plants, setPlants] = useState([]);

  //similar syntax to deletePlant, but requires a POST request and a body with new plant data
  const addPlant = async(newPlant) => {
    try {
      const response = await fetch(`http://localhost:8080/users/${userId}/plants`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(newPlant)
      })
      if (response.ok) {
        const addedPlant = await response.json()
        setPlants([...plants, addedPlant])
      } else {
        console.error('Failed to add plant')
      }
    } catch (error) {
      console.error('Error adding plant:', error)
    }
  }

  const deletePlant = async (plantId) => {
  try {
    const response = await fetch(`http://localhost:8080/users/${userId}/plants/${plantId}`, {
      method: 'DELETE'
    })
    if (response.ok) {
      setPlants(plants.filter(plant => plant.plantId !== plantId))
    } else {
      console.error('Failed to delete plant')
    }
  } catch (error) {
    console.error('Error deleting plant:', error)
  }
}

useEffect(() => {
  const fetchPlants = async () => {
    try {
      const response = await fetch(`http://localhost:8080/users/${userId}/plants`)
      const data = await response.json()
      setPlants(data)
    } catch (error) {
      console.error('Error fetching plants:', error)
    }
  }
  fetchPlants()
}, [userId])

const updatePlantNickname = (plantId, newNickname) => {
  setPlants(plants.map(plant => 
    plant.plantId === plantId ? { ...plant, nickname: newNickname } : plant
  ));
}

  return (
    <div className='app-wrapper'>
      <Header />
      <main>
        <Routes>
            <Route path="/" element={<HomePage />} />
            <Route path="/collection" element={<CollectionPage plants={plants} addPlant={addPlant} deletePlant={deletePlant} updatePlantNickname={updatePlantNickname} userId={userId} />} />
            <Route path="/about" element={<AboutPage />} />
            <Route path="/contact" element={<ContactPage />} />
        </Routes>
      </main>
      <Footer />
    </div>
  )
}

export default App;
