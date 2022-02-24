<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Tracking site</title>
</head>
<body>

<form method="post" action="/findcontainer">
    <label>Search anything else:
        <input name="fullnamecontainer" placeholder="Container number">
    </label>
    <input type="submit" value="Найти">
</form>

<h1></h1>
<p>request: ${output}</p>
<p>-------------------------</p>

<p>line: ${result.getLine()}</p>
<p>container number: ${result.getContainerNumber()}</p>
<p>type of container: ${result.getContainerData()}</p>
<p>-------------------------</p>

<p>terminal of departure: ${result.getTerminalDeparture()}</p>
<p>port of departure: ${result.getPortDeparture()}</p>
<p>country of departure: ${result.getCountryDeparture()}</p>
<p>date of loading: ${result.getDateOfLoading()}</p>
<p>-------------------------</p>

<p>port of arrival: ${result.getPortArrival()}</p>
<p>country of arrival: ${result.getCountryArrival()}</p>
<p>date of arrival: ${result.getDateOfArrival()}</p>
<p>-------------------------</p>

<p>vessel: ${result.getVessel()}</p>





</body>
</html>