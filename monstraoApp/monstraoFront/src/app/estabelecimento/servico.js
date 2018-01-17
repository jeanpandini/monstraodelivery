import AbstractCrudService from "../abstract.crud.service";

export default class EstabeleciemntoServico extends AbstractCrudService {

  constructor($http) {
    super($http, 'http://localhost:8080/monstraoApp-web/api/estabelecimento')
  }

}

EstabeleciemntoServico.$inject = ['$http']