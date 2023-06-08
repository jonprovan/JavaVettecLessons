import { Artist } from "./artist";

export class Album {

    // properties
    albumId: number = 0;
    title: string = '';
    artist: Artist = new Artist(0, '', '', 0);
    genre: string = '';
    label: string = '';
    trackCount: number = 0;
    imageUrl: string = '';

    constructor(albumId: number,
                title: string,
                artist: Artist,
                genre: string,
                label: string,
                trackCount: number,
                imageUrl: string) {
        this.albumId = albumId;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.label = label;
        this.trackCount = trackCount;
        this.imageUrl = imageUrl;
    }

    // get albumId(): number {
    //     return this.#albumId;
    // }

    // get title(): string {
    //     return this.#title;
    // }

    // get artist(): Artist {
    //     return this.#artist;
    // }

    // get genre(): string {
    //     return this.#genre;
    // }
    // get label(): string {
    //     return this.#label;
    // }

    // get trackCount(): number {
    //     return this.#trackCount;
    // }

    // set albumId(albumId: number) {
    //     this.#albumId = albumId;
    // }

    // set title(title: string) {
    //     this.#title = title;
    // }

    // set artist(artist: Artist) {
    //     this.#artist = artist;
    // }

    // set genre(genre: string) {
    //     this.#genre = genre;
    // }

    // set label(label: string) {
    //     this.#label = label;
    // }

    // set trackCount(trackCount: number) {
    //     this.#trackCount = trackCount;
    // }
}
