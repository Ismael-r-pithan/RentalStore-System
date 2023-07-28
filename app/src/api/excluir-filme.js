import { instance } from "../configs/httpClient";

export async function excluirFilme({ id }) {
  await instance.delete(`/filmes/${id}`);
}
