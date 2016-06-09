<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>PowerCo RESTful Services</title>
		<style type="text/css" media="screen">
			#status {
				background-color: #eee;
				border: .2em solid #fff;
				margin: 2em 2em 1em;
				padding: 1em;
				width: 12em;
				float: left;
				-moz-box-shadow: 0px 0px 1.25em #ccc;
				-webkit-box-shadow: 0px 0px 1.25em #ccc;
				box-shadow: 0px 0px 1.25em #ccc;
				-moz-border-radius: 0.6em;
				-webkit-border-radius: 0.6em;
				border-radius: 0.6em;
			}

			.ie6 #status {
				display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
			}

			#status ul {
				font-size: 0.9em;
				list-style-type: none;
				margin-bottom: 0.6em;
				padding: 0;
			}

			#status li {
				line-height: 1.3;
			}

			#status h1 {
				text-transform: uppercase;
				font-size: 1.1em;
				margin: 0 0 0.3em;
			}

			#page-body {
				margin: 2em 1em 1.25em 18em;
			}

			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}

			p {
				line-height: 1.5;
				margin: 0.25em 0;
			}

			#controller-list ul {
				list-style-position: inside;
			}

			#controller-list li {
				line-height: 1.3;
				list-style-position: inside;
				margin: 0.25em 0;
			}

			@media screen and (max-width: 480px) {
				#status {
					display: none;
				}

				#page-body {
					margin: 0 1em 1em;
				}

				#page-body h1 {
					margin-top: 0;
				}
			}
		</style>
	</head>
	<body>
		<a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="status" role="complementary">
			<h1>Application Status</h1>
			<ul>
				<li>App version: <g:meta name="app.version"/></li>
				<li>Grails version: <g:meta name="app.grails.version"/></li>
				<li>Groovy version: ${GroovySystem.getVersion()}</li>
				<li>JVM version: ${System.getProperty('java.version')}</li>
				<li>Reloading active: ${grails.util.Environment.reloadingAgentEnabled}</li>
				<li>Controllers: ${grailsApplication.controllerClasses.size()}</li>
				<li>Domains: ${grailsApplication.domainClasses.size()}</li>
				<li>Services: ${grailsApplication.serviceClasses.size()}</li>
				<li>Tag Libraries: ${grailsApplication.tagLibClasses.size()}</li>
			</ul>
			<h1>Installed Plugins</h1>
			<ul>
				<g:each var="plugin" in="${applicationContext.getBean('pluginManager').allPlugins}">
					<li>${plugin.name} - ${plugin.version}</li>
				</g:each>
			</ul>
		</div>
		<div id="page-body" role="main">
			<h1>Welcome to the PowerCo RESTful Services</h1>
			<p>PowerCo RESTFul services. Below is a list of controllers that are currently deployed in this application,
			   click on each to execute its default action in your browser:</p>

			<div id="controller-list" role="navigation">
				<h2>Available Controllers:</h2>
				<ul>
					<g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
						<li class="controller"><g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link></li>
					</g:each>
				</ul>
			</div>

            <p>&nbsp;<p>
			You can test a RESTful service with the <code>curl</code> command:
			<br>

			<pre><code>curl -X GET -H "Accept:application/json" http://[url]/RESTTest/api/invoices/1</code></pre>
            <p>&nbsp;<p>

            Sample output should resemble the following:
            <samp>
            [{"class":"resttest.Invoice","id":1,"accountNumber":"000001",...}]
            </samp>
            <p>&nbsp;<p>

			Or, use this Python script to GET and decode JSON objects from an API endpoint:<br>

			<pre><code>
from sys import argv
import urllib2
import time
import sys
import json

script, args0=argv

# take the endpoint URL as the first argument
baseurl=args0

url=baseurl
startTime=int(round(time.time() * 1000))
endTime=0;
sys.stdout.write(url + ": GETting invoice... ")

opener=urllib2.build_opener()

# ask the API to return JSON (you could also use 'text/xml' to return XML)
opener.addheaders=[('Accept', 'application/json')]

try:
    # our response string should result in a JSON object
    response = opener.open(url).read()

    endTime=int(round(time.time() * 1000))
    print "done (" + str(endTime-startTime) + " ms)."

    print str(response)

except urllib2.HTTPError:
    print "Error in GET..."

# decode the returned JSON response into JSONInvoice (a Python dict object)
JSONinvoice = json.loads(str(response))

print JSONinvoice
strAmountDollars=str(JSONinvoice['amountDollars'])
strAmountCents=str(JSONinvoice['amountCents'])

print "The amount of the invoice object returned is: " + strAmountDollars
            </code></pre>

		</div>
	</body>
</html>
