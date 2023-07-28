import style from "./inserir-filme.module.css";

import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { inserirFilme } from "../../../api/inserir-filme";
import { Button } from "../../components/button/button.component";

export function InserirFilmeScreen() {

    const [ formInput, setFormInput ] = useState({ titulo: '', descricao: '', categoria: '' });

    const navigate = useNavigate();

    async function onInserirFilme(titulo, descricao, categoria) {
        const response = await inserirFilme({ titulo, descricao, categoria });
        if (response?.status === 500) {
            alert(response.message);
        }
        navigate('/');
    }

    function handleSubmit(event) {
        event.preventDefault();
    }

    function handleChange(event) {
        const { name, value } = event.target;
        setFormInput(oldFormInput => ({ ...oldFormInput, [name]: value }));
    }

    return (
        <form onSubmit={handleSubmit} className={style.box}>
        <div className={style.boxInputs}>
            <input 
                onChange={handleChange} 
                type="text" 
                name="titulo" 
                placeholder="Informe o novo titulo"
                value={formInput.titulo}
            />
            <textarea 
                onChange={handleChange} 
                type="text" 
                name="descricao" 
                placeholder="Informe a nova descricao"
                value={formInput.descricao}
            />
            <select 
                onChange={handleChange} 
                type="text" 
                name="categoria" 
                defaultValue={formInput.categoria}
            >
                <option value="OURO"> ouro </option>
                <option value="PRATA"> prata </option>
                <option value="BRONZE"> bronze</option>
            </select>
            <Button onClick={async () => await onInserirFilme(formInput.titulo, formInput.descricao, formInput.categoria)} text="Incluir" />
        </div>
    </form>
    );
}