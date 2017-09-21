import * as tape from 'tape'
import * as supertest from 'supertest'
import app from './app'

tape('root returns text', t => {
    supertest(app)
    .get('/')
    .expect(200)
    .expect(res => t.same(res.text, 'Hello from the TypeScript world!'))
    .end(t.end)
})

tape.onFinish(() => process.exit(0))
