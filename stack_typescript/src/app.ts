import * as express from 'express'
import * as morgan from 'morgan'
import Storage from './storage'

const app: express.Application = express()
app.use(morgan('dev'))

app.all(
    '/db',
    (req: express.Request, res: express.Response) => {
        Storage('mysql://ts_user:ts_pw@db_mysql/ts_db').status()
        .then((ok) => {
            if (!ok) { throw Error('Bad response from database') }
            res.send('Connected to database')
        })
        .catch(() => res.send('Not connected to database'))
     }
 )
app.all(
    '/',
    (req: express.Request, res: express.Response) => res.send('Hello from the TypeScript world!')
)

const port = process.env.PORT || 3000
app.listen(port, () => console.log(`Express is up and running.`))

export default app
