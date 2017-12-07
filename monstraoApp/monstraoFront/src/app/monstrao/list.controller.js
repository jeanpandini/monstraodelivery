export default class ListController {
    
        constructor(MonstraoServico, Notification) {
            this.filter = ''
            this.records = []
            this._service = MonstraoServico
            this.load()
        }
    
        load() {
            this._service.findAll()
              .then(data => {
                  this.records = data
              })
              .catch(error => {
                  console.log(error)
              })
        }
    
        excluir(id) {
            this._service.remove(id)
                .then(response => {
                    this.load()
                }).catch(erro => {
                }) 
        }
    }
    
    ListController.$inject = ['MonstraoServico', 'Notification']