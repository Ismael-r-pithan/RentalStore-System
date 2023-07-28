import { useEffect, useState } from "react";
import { listarFilmes } from "../../../api/listar-filmes";
import { FilmeCard } from "../../components/filme/filme-card.component";
import { Header } from "../../components/header/header.component";

export function HomeScreen() {

    const [filmes, setFilmes] = useState([]);

    useEffect(() => {
        async function buscarFilmes() {
            const data = await listarFilmes();

            if (data?.status === 500) {
                alert(data.message);
                setFilmes([]);
            } else {
                setFilmes(data);
            }
        }

        buscarFilmes();
    }, [filmes])

    return (
            <div>
                <Header />
                <main>
                {filmes.map(filme => {
                    return (
                        <FilmeCard 
                            key={filme.id}
                            id={filme.id}
                            titulo={filme.titulo} 
                            descricao={filme.descricao}
                            disponivel={filme.disponivel}   
                            categoria={filme.categoria} 
                        />
                    );
                })}
                </main>
            </div>
    );
}