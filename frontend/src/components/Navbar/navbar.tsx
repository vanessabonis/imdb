import {ReactComponent as GithubIcon} from 'assets/img/github-logo.svg';
import './styles.css'

function Navbar() {
    return (
        <header>
            <nav className="container">
                <div className="dsmovie-nav-content">
                    <a href="http://localhost:3000/"><h1>DSMovie</h1></a> 
                    <a href="https://github.com/vanessabonis">
                        <div className="dsmovie-contact-container"> 
                            <GithubIcon />
                            <p className="dsmovie-contact-link">/vanessabonis</p>
                        </div>
                    </a>
                </div>
            </nav>
        </header>
    );
}

export default Navbar;