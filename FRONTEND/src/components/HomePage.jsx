import { useNavigate } from "react-router-dom";
import logo from '../assets/logo.png'
function HomePage() {
    const navigate = useNavigate();

    return (
        <main className="home-page">
            <div className="home-content">
                <img src={logo} alt='Flourish logo' className="logo-sway" />
                <p className="tagline">Designed to make taking care of plants rewarding, not stressful!</p>
                <button className="start-btn" onClick={() => navigate('/collection')}>
                    Start Collecting
                </button>
            </div>
        </main>
    )
}

export default HomePage;