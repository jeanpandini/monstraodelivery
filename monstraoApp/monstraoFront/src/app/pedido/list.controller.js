export default class ListController {
    
        constructor(PedidoServico) {
            this.filter = ''
            this.records = []
            this._service = PedidoServico
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
                })
        }
    }
    
    ListController.$inject = ['PedidoServico']