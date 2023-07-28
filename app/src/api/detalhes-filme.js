import { instance } from "../configs/httpClient";

export async function detalhesFilme({ id }) {
  const response = await instance.get(`/filmes/${id}`);
  return response.data;
}
