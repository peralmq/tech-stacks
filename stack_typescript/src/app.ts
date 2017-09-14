import * as express from 'express'
import * as morgan from 'morgan'

const app: express.Application = express()
app.use(morgan('dev'))
app.all('/', (req, res) => res.send('Hello from the TypeScript world!'))

const port = process.env.PORT || 3000
app.listen(port, () => console.log(`Express is up and running.`))
