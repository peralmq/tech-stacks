import * as knex from 'knex'

export interface Storage { status() }
export default (connectionString: string): Storage => {
    const db: knex = knex({
        client: 'mysql',
        connection: connectionString
    })

    return {
        status: () => db.raw('SELECT 1').then(result => !!result[0][0])
    }
}
