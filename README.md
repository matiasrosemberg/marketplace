### Decisions made:

Use of Hashmap <k, v> structures allows you to search by key and access projects and bids efficiently.

---

### Endpoint information: `(Dev mode)`

Base develop endpoint:

`http://localhost:9290/self-employed-marketplace/`

#### Create new project:

`POST`

`/seller/`

RequestBody:
`{
"description": {String},
"maxBudget": {Double},
"bidEndingTime": {DATE (YYYY-MM-DD)}
}`

POST to: `http://localhost:9290/self-employed-marketplace/seller/`

Example:
`{
"description":"test",
"maxBudget":100,
"bidEndingTime":"2021-03-15"
}`

Example answer:
`{
"id": 1,
"createdAt": "2021-03-08",
"projectData": {
"description": "test",
"maxBudget": 100.0,
"bidEndingTime": "2021-03-15"
}`

#### Create new bid:

`POST`

`/buyer/`

RequestBody:
`{
"projectId": {Integer},
"actualBid": {Double},
"devId": {Integer}
}`

POST to: `http://localhost:9290/self-employed-marketplace/buyer/`

Example:
`{
"description":"test",
"maxBudget":100,
"bidEndingTime":"2021-03-15"
}`

Example answer:
`{
"id": 1,
"createdAt": "2021-03-08",
"projectData": {
"description": "test",
"maxBudget": 100.0,
"bidEndingTime": "2021-03-15"
}`

#### Create new bid:

`GET`

`/buyer/{projectId}`

Example GET: `http://localhost:9290/self-employed-marketplace/seller/1`

Example response:
`{
"project": {
"id": 1,
"createdAt": "2021-03-08",
"projectData": {
"description": "test",
"maxBudget": 100.0,
"bidEndingTime": "2021-03-15"
}
},
"maxBid": {
"projectId": 1,
"actualBid": 91.5,
"devId": 10230,
"createdAt": "2021-03-08"
}
}`

#### Actuator Health-Check:

GET to `/self-employed-marketplace/actuator/health`

### How to start the app?

Clone project: `https://github.com/matiasrosemberg/marketplace.git`

Open console in project folder and run:

`mvn clean install`

After this, target folder will be generated.

Run on a console inside the project folder:

`java -jar target/self-employed-marketplace-0.0.1-SNAPSHOT.jar`

Wait until works.
You can now use the app in local mode.