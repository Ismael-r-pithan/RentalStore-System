import style from './button.module.css';

export function Button({ text, onClick }) {
    return (
        <button className={style.button} onClick={onClick}>{text}</button>
    );
}