import resttest.Account
import resttest.Customer
import resttest.Invoice

/*
    The fields from our invoice are as follows:

    String invoiceId
    String accountId
    String customerId
    String serviceAddress
    Date servicePeriodStart
    Date servicePeriodEnd
    long amountDollars
    long amountCents
    long currentMeterReading
    long previousMeterReading
    String serviceCity
    String servicePostalcode
    String serviceCountrycode

 */

class BootStrap {

    def init = { servletContext ->
        def invoice0 = new Invoice(
                invoiceId: "12345",
                accountId: "000001",
                customerId: "jpdixon",
                servicePeriodStart: new Date("5/1/2016"),
                servicePeriodEnd: new Date("5/31/2016"),
                amountDollars: 94,
                amountCents: 28,
                currentMeterReading: 54318,
                previousMeterReading: 53570
        )

        def invoice1 = new Invoice(
                invoiceId: "12346",
                accountId: "000001",
                customerId: "jpdixon",
                servicePeriodStart: new Date("6/1/2016"),
                servicePeriodEnd: new Date("6/31/2016"),
                amountDollars: 98,
                amountCents: 29,
                currentMeterReading: 53570,
                previousMeterReading: 53611
        )

        def invoice2 = new Invoice(
                invoiceId: "54321",
                accountId: "000002",
                customerId: "jpdixon",
                servicePeriodStart: new Date("2/1/2017"),
                servicePeriodEnd: new Date("2/28/2017"),
                amountDollars: 138,
                amountCents: 26,
                currentMeterReading: 98,
                previousMeterReading: 981
        )

        /*
        // we won't use invoices 3,4,5 in this version for the POC
        def invoice3 = new Invoice(
                invoiceId: "54322",
                accountId: "000002",
                customerId: "jpdixon",
                servicePeriodStart: new Date("6/1/2016"),
                servicePeriodEnd: new Date("6/31/2016"),
                amountDollars: 297,
                amountCents: 11,
                currentMeterReading: 445,
                previousMeterReading: 556
        )

        def invoice4 = new Invoice(
                invoiceId: "54323",
                accountId: "000003",
                customerId: "jpdixon",
                servicePeriodStart: new Date("6/1/2016"),
                servicePeriodEnd: new Date("6/31/2016"),
                amountDollars: 1293,
                amountCents: 9,
                currentMeterReading: 445,
                previousMeterReading: 556
        )

        def invoice5 = new Invoice(
                invoiceId: "54324",
                accountId: "000003",
                customerId: "jpdixon",
                servicePeriodStart: new Date("6/1/2016"),
                servicePeriodEnd: new Date("6/31/2016"),
                amountDollars: 1921,
                amountCents: 10,
                currentMeterReading: 445,
                previousMeterReading: 556
        )
        */

        def account0=new Account(invoices: [invoice0],
                accountId: "000001",
                serviceAddress: "501 North High Street",
                serviceCity: "Columbus",
                servicePostalcode: "43215",
                serviceCountrycode: "US"
        )

        def account1=new Account(invoices: [invoice1],
                accountId: "000002",
                serviceAddress: "155 West Nationwide",
                serviceCity: "Columbus",
                servicePostalcode: "43215",
                serviceCountrycode: "US"
        )

        def account2=new Account(invoices: [invoice2],
                accountId: "000003",
                serviceAddress: "1 Riverside Plaza",
                serviceCity: "Columbus",
                servicePostalcode: "43215",
                serviceCountrycode: "US"
        )

        def customer0=new Customer(accounts: [account0, account1, account2],
            customerId: "001",
            firstName: "Scott",
            lastName: "Hewitt")

        // we don't need to save each invoice -- saving the account will also save the invoice objects
        assert customer0.save(failOnError: true, flush: true, insert: true)

    }

    def destroy = {

    }
}
