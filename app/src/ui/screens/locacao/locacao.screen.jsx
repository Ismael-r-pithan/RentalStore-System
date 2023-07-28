import style from "./locacao.module.css";

import { useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { alugarFilme } from "../../../api/alugar-filme";
import { Button } from "../../components/button/button.component";

export function LocacaoScreen() {

    const [responsavel, setResponsavel] = useState('');

    const navigate = useNavigate();

    const { id } = useParams();

    async function onLocacaoFilme(filmeId, responsavel) {
        await alugarFilme({ id: filmeId, responsavel });

        navigate('/');
    }

    function handleSubmit(event) {
        event.preventDefault();
    }

    function handleChange(event) {
        const { value } = event.target;

        setResponsavel(value);
    }
    return (
        <form onSubmit={handleSubmit} className={style.box}>
            <div className={style.boxInputs}>
                <input onChange={handleChange} type="text" name="responsavel" placeholder="Informe o nome do cliente" />
                <Button onClick={async () => await onLocacaoFilme(id, responsavel)} text="Alugar" />
            </div>
        </form>
    );
}