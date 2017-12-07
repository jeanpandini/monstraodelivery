import AbstractCrudService from "../abstract.crud.service";

export default class MonstraoServico extends AbstractCrudService {

  constructor($http) {
    super($http, 'http://localhost:8080/monstraoApp-web/api/monstrao')
  }

}

MonstraoServico.$inject = ['$http']