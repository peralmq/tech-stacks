import * as tape from 'tape'
import Storage from './storage'

tape('database connection', t => {
    Storage('mysql://services:IAmATeapot57@127.0.0.1/services')
    .status()
    .then(ok => t.true(ok))
    .catch(t.end)
})

tape.onFinish(() => process.exit(0))
