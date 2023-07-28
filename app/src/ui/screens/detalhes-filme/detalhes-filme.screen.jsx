import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { detalhesFilme } from "../../../api/detalhes-filme";
import { DetalhesFilme } from "../../components/filme/detalhes-filme.component";

export function DetalhesFilmeScreen() {

    const { id } = useParams();

    const [filme, setFilme] = useState({});

    useEffect(() => {
        async function locacao(filmeId) {
            const data = await detalhesFilme({ id: filmeId});
            setFilme(data);
        }

        locacao(id);
    }, [id]);

    return (
        <DetalhesFilme 
            titulo={filme.titulo} 
            descricao={filme.descricao} 
            disponivel={filme.disponivel} 
            categoria={filme.categoria} 
            responsavel={filme.responsavel}
            dataRetirada={filme.dataRetirada} 
            dataEntrega={filme.dataEntrega}
            situacao={filme.situacao} 
        />
    );
}