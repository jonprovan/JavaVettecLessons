// generate a model using -- ng g class <className>

// this is not a component but rather a data model
// for things coming back from/going to our database

export class Artist {

    // in TS, we must include the types of the variables

    // keeping this public, because when posting/deleting, etc., the variable values get masked

    artistId: number = 0;
    name: string = '';
    type: string = '';
    founded: number = 0;

    constructor(artistId: number,
                name: string,
                type: string,
                founded: number) {
        this.artistId = artistId;
        this.name = name;
        this.type = type;
        this.founded = founded;
    }

    // in TS, you must state the return type
    // some exceptions to this arise here and there
    // good to get in the habit
    // get artistId(): number {
    //     return this.#artistId;
    // }
    // get name(): string {
    //     return this.#name;
    // }
    // get type(): string {
    //     return this.#type;
    // }
    // get founded(): number {
    //     return this.#founded;
    // }

    // set artistId(artistId: number) {
    //     this.#artistId = artistId;
    // }

    // set name(name: string) {
    //     this.#name = name;
    // }

    // set type(type: string) {
    //     this.#type = type;
    // }

    // set founded(founded: number) {
    //     this.#founded = founded;
    // }

}
