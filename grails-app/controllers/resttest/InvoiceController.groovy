package resttest

import grails.rest.RestfulController

class InvoiceController extends RestfulController {
    static responseFormats=['json', 'xml']

    InvoiceController() {
        super(Invoice)
    }

}
