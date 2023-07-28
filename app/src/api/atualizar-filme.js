import { instance } from "../configs/httpClient";

export async function atualizarFilme({ id, titulo, descricao, categoria }) {
  await instance.put(`/filmes/${id}`, {
    titulo, descricao, categoria
  });
}
