import {ReactComponent as GithubIcon} from 'assets/img/github-logo.svg';
import './navbar.css'

function Navbar() {
    return (
        <header>
            <nav className="container">
                <div className="dsmovie-nav-content">
                    <a href="https://imdb-dsmovie.netlify.app"><h1>DSMovie</h1></a> 
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