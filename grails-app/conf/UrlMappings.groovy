class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')

        "/api/invoices" (resources:"invoice")
        "/invoices" (controller:"InvoiceController")

        "/api/accounts" (resources:"account")
        "/accounts" (controller:"AccountController")

        "/api/customer" (resources:"customer")
        "/customers" (controller:"CustomerController")
	}
}
