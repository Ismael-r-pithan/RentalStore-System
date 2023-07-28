import style from './header.module.css';

import { Link } from 'react-router-dom';
import oldFlixIcon from '../../../assets/icons/oldflix.png';

export function Header() {
    return (
        <header className={style.box}>
            <Link to="/" className={style.boxIcons}>
                <img src={oldFlixIcon} alt="Icone OldFlix" />
                <h1>Old Flix</h1>
            </Link>

            <nav>
                <Link to="/">Inicio</Link>
                <Link to="/inserir-filme">Incluir Filmes</Link>
            </nav>
        </header>
    );
}