import * as express from 'express'
import * as morgan from 'morgan'
import * as knex from 'knex'

const app: express.Application = express()
app.use(morgan('dev'))

app.all(
    '/db',
    (req: express.Request, res: express.Response) => {
        const db: knex = knex({
            client: 'mysql',
            connection: 'mysql://ts_user:ts_pw@db_mysql/ts_db'
        })

        db.raw('SELECT 1')
        .then(() => res.send('Connected to database'))
        .catch(() => res.send('Not connected to database'))
     }
 )
app.all(
    '/',
    (req: express.Request, res: express.Response) => res.send('Hello from the TypeScript world!')
)

const port = process.env.PORT || 3000
app.listen(port, () => console.log(`Express is up and running.`))
