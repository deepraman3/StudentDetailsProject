import {Link} from 'react-router-dom';
import './navbar.css';
const Navbar = () => {
    return (
        <div className="navbar">
            <div className="logo">
            <Link to="/" style={{textDecoration:"none"}}><span className="logo-entry">ActiveCampus</span></Link>
            </div>
            <div className="links">
                <Link to="/" style={{textDecoration:"none"}}><span className="entries">Home</span></Link>
                <Link to="/Profile" style={{textDecoration:"none"}}><span className="entries">Profile</span></Link>
                <Link to="/Help" style={{textDecoration:"none"}}><span className="entries">Help</span></Link>
            </div>
        </div>
    );
};

export default Navbar;