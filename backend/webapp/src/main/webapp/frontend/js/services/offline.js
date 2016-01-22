angular.module(
    'ecp-contactapp.services.offline', [])

    // stores all data under a single key, so can enumerate all.
    .service(
        'OfflineService',
        ['AppConfig',
        function(AppConfig) {

        var service = this;

        var localStorageKey = AppConfig.appPrefix + ".data"

        var internalGet = function() {
            var storedStr = window.localStorage[localStorageKey]
            if(!storedStr) {
                stored = {}
                window.localStorage[localStorageKey] = JSON.stringify(stored)
                return stored
            } else {
                return JSON.parse(storedStr)
            }
        }

        var internalPut = function(stored) {
            var numItems = Object.keys(stored).length
            window.localStorage[localStorageKey] = JSON.stringify(stored)
            _stored = stored
        }

        // in-memory copy
        var _stored = internalGet();


        this.get = function(cacheKey) {
            var stored = internalGet()
            return stored[cacheKey]
        }

        this.put = function(cacheKey, resp) {
            var stored = internalGet()
            stored[cacheKey] = {
                resp: resp,
                date: new Date()
            }
            internalPut(stored)
        }

        this.lookup = function(cacheKey) {
            return _stored[cacheKey]
        }

        this.isCached = function(cacheKey) {
            var lookedUp = service.lookup(cacheKey)
            var cached = lookedUp !== undefined
            return cached
        }

        this.count = function() {
            return Object.keys(_stored).length
        }

        this.clearCache = function() {
            internalPut({})
        }

    }])


;
