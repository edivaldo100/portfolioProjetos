export class Projeto {
  constructor(
  public id: number | null,
  public nome: string,
  public dataInicio: Date,
  public dataPrevisaoFim: Date,
  public dataFim: Date,
  public descricao: string,
  public status: string,
  public orcamento: string,
  public risco: string,
  public idGerente: number,
  public gerente?: string | null,
  ) {}
}
