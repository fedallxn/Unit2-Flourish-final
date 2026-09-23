import { Link } from 'react-router-dom'
import headerLogo from '../assets/header-logo.png'

function Header() {
    return (
        <header>
            <div className='header-with-logo'>
                <img src={headerLogo} alt='Flourish Logo' className='header-logo' />
                <h1>FLOURISH</h1>
            </div>
                <nav>
                    <ul>
                        <li><Link to="/">Home</Link></li>
                        <li><Link to="/collection">Collection</Link></li>
                        <li><Link to="/about">About</Link></li>
                        <li><Link to="/contact">Contact</Link></li>
                    </ul>
                </nav>
        </header>
    )
}

export default Header;